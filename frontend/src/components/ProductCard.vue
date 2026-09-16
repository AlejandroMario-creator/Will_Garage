<script setup lang="ts">
import type { Product } from '../types/Product';

defineProps<{
    product:Product;
}>();
</script>
<template>
    <article class="product-card">
           <img 
                v-if="product.imageUrl"
                v-bind:src="product.imageUrl"
                v-bind:alt="product.name"
                class="product-image"
            />
            <div class="product-info">
                <span v-if="product.series" class="series">
                    {{ product.series }}
                </span>

                <h2>{{ product.series }}</h2>

                <p v-if="product.vehicleBrand">
                    {{ product.vehicleBrand }}
                </p>

                <strong>S/ {{ product.price.toFixed(2) }}</strong>

                <p>
                    Stock: {{ product.stock }}
                </p>

                <span v-if="product.rarity">
                    {{ product.rarity }}
                </span>
            </div>   
    </article>
</template>

<style scoped>
.product-card {
  width: 280px;
  border: 1px solid #ddd;
  border-radius: 12px;
  overflow: hidden;
}

.product-image {
  width: 100%;
  height: 220px;
  object-fit: cover;
}

.product-info {
  padding: 16px;
}

.series {
  font-size: 13px;
}
</style>