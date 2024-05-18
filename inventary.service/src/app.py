from flask import Flask
from flask_cors import CORS
from src.Productos.Infrastructure.Routes.ProductsRoutes import products_routes

app = Flask(__name__)
app.register_blueprint(products_routes,url_prefix="/products")
CORS(app)

if __name__ == 'main':
    app.run(debug=True, port= 3001)