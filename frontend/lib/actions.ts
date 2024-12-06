"use server"

import { API_URL } from "@/lib/api"
import { LineItemType } from "@/lib/types"

export async function createOrder(lineItems: LineItemType[]) {
  const body = {
    table_number: 1,
    line_item_list: lineItems.map((lineItem) => ({
      item_id: lineItem.id,
      item_name: lineItem.name,
      item_price: lineItem.price,
      amount: lineItem.amount,
    })),
  }

  const res = await fetch(`${API_URL}/orders`, {
    method: "POST",
    body: JSON.stringify(body),
    headers: {
      "Content-Type": "application/json",
    },
  })

  console.log({ body })
  console.log({ res })

  if (!res.ok) {
    throw new Error("Failed to fetch data")
  }

  return res.json()
}
