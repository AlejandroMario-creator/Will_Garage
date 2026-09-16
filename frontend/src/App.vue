<script setup lang="ts">
import { onMounted, ref } from 'vue';
import type { Product } from './types/Product.ts';
import { getProducts } from './services/productService';
import ProductCard from './components/ProductCard.vue';

const products = ref<Product[]>([]);

async function  loadProducts() {
  try {
    products.value = await getProducts();
  } catch (error){
    console.error(error);
  }
  
}

onMounted(() => {
  loadProducts();
});
</script>

<template>
  <main>
    <h1>Will Garage</h1>
    <div class="products">
      <ProductCard
      v-for="product in products"
      v-bind:key="product.id"
      v-bind:product="product"
      />
    </div>
  </main>
</template>

<style></style>