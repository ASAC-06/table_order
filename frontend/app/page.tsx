import Image from "next/image"

import { API_URL, getItems } from "@/lib/api"
import { ItemType } from "@/lib/types"
import { ItemCard } from "@/components/item/card"
import { ItemDialog } from "@/components/item/dialog"
import ItemGrid from "@/components/item/grid"

export default async function Home() {
  const items = await getItems()

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
