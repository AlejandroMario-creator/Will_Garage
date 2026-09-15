export type Rarity =
    | "MAINLINE"
    | "PREMIUM"
    | "TREASURE_HUNT"
    | "SUPER_TREASURE_HUNT";


export interface Product{
    id: number;
    name: string;
    sku: string;
    description?: string;
    price: number;
    stock: number;
    
    manufacturer?: string;
    vehicleBrand?: string;
    model?: string;
    year?: number;
    color?: string;
    scale?: string;
    series?: string;

    rarity?: Rarity;
    imageUrl?: string;

    active: boolean;
    createdAt: string;
    updatedAt?: string;
}