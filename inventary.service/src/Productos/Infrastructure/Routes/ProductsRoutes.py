from crypt import methods
from flask import Blueprint, request
from src.Productos.Infrastructure.Controllers.CreateController import CreateCrontoller
from src.Productos.Infrastructure.Controllers.GetController import GetController
from src.Productos.Infrastructure.Controllers.DeleteController import DeleteController
from src.Productos.Infrastructure.Repositories.ProductsRepository import ProducstRepository

products_routes = Blueprint('products_routes', __name__)

repo = ProducstRepository()
get_controller = GetController(repo)
delete_controller = DeleteController(repo)
create_controller = CreateCrontoller(repo)


@products_routes.route('/', methods= ["GET"])
def get():
    return get_controller.run()


@products_routes.route('/', methods= ["POST"])
def create():
    return create_controller.run()


@products_routes.route('/<string:id>', methods= ["DELETE"])
def delete(id):
    return delete_controller.run()