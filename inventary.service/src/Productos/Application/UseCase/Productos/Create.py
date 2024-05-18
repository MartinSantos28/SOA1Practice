from src.Productos.Domain.Ports.ProductsPort import ProductsPort as Port, Products

class CreateUseCase:
    def __init__(self, repository : Port):
        self.__repository = repository
        
    def run(self, data):
        products = [Products(**d) for d in data]
        return self.__repository.create_products(products)