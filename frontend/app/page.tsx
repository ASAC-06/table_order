import Image from "next/image"

import { API_URL } from "@/lib/api"
import { ItemType } from "@/lib/types"
import { ItemCard } from "@/components/item/card"
import { ItemDialog } from "@/components/item/dialog"
import ItemGrid from "@/components/item/grid"

export default async function Home() {
  const items: ItemType[] = await fetch(`${API_URL}/items`).then((res) =>
    res.json()
  )

  return (
    <div className="p-6">
      <ItemDialog />
      <ItemGrid>
        {items.map((item) => (
          <div key={item.id}>
            <ItemCard {...item}></ItemCard>
          </div>
        ))}
      </ItemGrid>
    </div>
  )
}
