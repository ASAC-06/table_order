import { categoryType, ItemType } from "@/lib/types"

export const API_URL = process.env.API_URL || "localhost:8080"

export async function getCategories(): Promise<categoryType[]> {
  const res = await fetch(`${API_URL}/categories`)

  if (!res.ok) {
    throw new Error("Failed to fetch data")
  }

  return res.json()
}

export async function getItems(): Promise<ItemType[]> {
  const res = await fetch(`${API_URL}/items`)

  if (!res.ok) {
    throw new Error("Failed to fetch data")
  }

  return res.json()
}
