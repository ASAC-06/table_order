"use client"

import Image from "next/image"

import { useItemDialogStore } from "@/lib/store"
import { ItemType } from "@/lib/types"
import { Card, CardFooter, CardHeader, CardTitle } from "@/components/ui/card"
import { Label } from "@/components/ui/label"

export function ItemCard(item: ItemType) {
  const { id, name, price } = item
  const displayPrice = price
  const { setItem } = useItemDialogStore()

  return (
    <Card onClick={() => setItem(item)}>
      <div>
        <Image
          src="https://placehold.co/400x400.png"
          alt="sample image"
          width={400}
          height={400}
          className="rounded-t-xl object-cover"
          style={{ objectFit: "cover" }}
        ></Image>
      </div>
      <CardHeader>
        <CardTitle className="text-sm">{name}</CardTitle>
      </CardHeader>
      <CardFooter className="justify-end">
        <Label className="">{displayPrice}원</Label>
      </CardFooter>
    </Card>
  )
}
