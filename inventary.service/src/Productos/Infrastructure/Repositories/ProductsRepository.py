from email import message
from itertools import product
from urllib import response

from fastapi import responses
from httpx import delete
from src.DataBase.Connection import Base, engine, session_local
from src.Productos.Domain.Ports.ProductsPort import ProductsPort
from src.Productos.Domain.Entities.Products import Products
from src.Productos.Infrastructure.Models.Products import Products as Model 
from src.Productos.Infrastructure.DTOS.Responses.BaseResponse import BaseResponse

class ProducstRepository(ProductsPort):
    def __init__(self):
        Base.metadata.create_all(bind=engine)
        self.db = session_local
        
    def get_products(self):
         products = [p.to_dict() for p in self.db.query(Model).all()]
         status = True if products else False
         message = "Productos encontrados exisitosamente" if status else "Productos no encontrados"
         status_code = 200 if status else 500
         return self.generate_response(responses,products,message, status, status_code )
     
    def create_products(self, products: list[Products]):
         news = [Model(**product.__dict__) for product in products]
         [self.db.add(new) for new in news]
         self.db.commit()
         responses = [n.to_dict for n in news]     
         return self.generate_response(responses, "Productos creados exitosamente", True, 201)

    def delete_products(self, id):
        product = self.db.query(Model).filter(Model.id == id).first()
        status = True
        status_code = 200
        message = 'Producto eliminado exitosamente'
        if product:
            self.db.delete(product)
            self.db.commit()
        else :
            status : False
            status_code =  500
            message = 'Producto no encontrado'
        return {"Message" : message, "Status" : status}, status_code
    
    def generate_response(self, data, message, status, httpsstatuscode):
        return BaseResponse(data, message, status , httpsstatuscode).resposne()