import type { Product } from "../types/Product";

const API_URL = "http://localhost:8080/api/products";

export async function getProducts(): Promise<Product[]> {
    const response = await fetch(API_URL);

    if (!response.ok) {
        throw new Error("Error al obtener los productos");
    }

    return response.json();
}