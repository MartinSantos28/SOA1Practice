from src.DataBase.Connection import Base
from sqlalchemy import Column, String, Integer , Float, false

class Products(Base):
    __tablename__ = 'products'
    id = Column(String(55), primary_key= True)
    name = Column(String(55),nullable=false)
    price = Column(Float,nullable=false)
    stock = Column(Integer,nullable=false)
    
    
    def to_dict(self):
        return {
            "id" : self.id,
            "name" : self.name,
            "price" : self.price,
            "stock" : self.stock
            }