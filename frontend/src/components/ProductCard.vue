<script setup lang="ts">
import type { Product } from '../types/Product';

defineProps<{
    product:Product;
}>();
</script>
<template>
    <img 
    v-if="product.imageUrl"
    :src="product.imageUrl"
    :alt="product.name"
    class="product-image"
    />
</template>