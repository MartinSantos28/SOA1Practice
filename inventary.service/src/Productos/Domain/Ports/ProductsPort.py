from src.Productos.Domain.Entities.Products import Products
from abc import ABC, abstractmethod

class ProductsPort(ABC):
    @abstractmethod
    def __init__(self):
        pass
    
    @abstractmethod
    def get_products(self):
        pass
    
    @abstractmethod
    def delete_products(self,id):
        pass
    
    @abstractmethod
    def create_products(self, products : list [Products]):
        pass