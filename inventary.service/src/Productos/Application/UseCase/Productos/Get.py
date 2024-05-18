from src.Productos.Domain.Ports.ProductsPort import ProductsPort as Port 

class GetUseCase:
    def __init__(self, repository : Port):
        self.__repository = Port
        
    def run(self):
        return self.__repository.get_products()