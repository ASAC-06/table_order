"use client"

import { useEffect, useState } from "react"
import Image from "next/image"
import { Minus, Plus } from "lucide-react"

import { useItemDialogStore, useLineItemStore } from "@/lib/store"
import { Button } from "@/components/ui/button"
import {
  Dialog,
  DialogClose,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
} from "@/components/ui/dialog"
import { Label } from "@/components/ui/label"

export function ItemDialog() {
  const { item, removeItem } = useItemDialogStore()
  const { setLineItem, findLineItem } = useLineItemStore()
  const lineItem = findLineItem(item?.id)
  const [amount, setAmount] = useState(0)

  function onClick(adjustment: number) {
    setAmount(amount + adjustment)
  }

  useEffect(() => {
    if (lineItem) {
      setAmount(lineItem.amount)
    }
  }, [lineItem])

  return (
    <Dialog
      open={item !== undefined}
      onOpenChange={(state) => {
        if (!state) {
          removeItem()
          setAmount(0)
        }
      }}
    >
      <DialogContent>
        <DialogHeader>
          <DialogTitle>{item?.name}</DialogTitle>
          <DialogDescription>{item?.description}</DialogDescription>
        </DialogHeader>
        <div className="justify-items-center py-4">
          <div className="items-center pb-6">
            <Image
              src={item?.imageSrc || "https://placehold.co/400x400.png"}
              alt={item?.imageAlt || "sample image"}
              width={300}
              height={200}
              className="rounded-xl object-cover h-64"
            ></Image>
          </div>

          <div className="flex items-center justify-center space-x-6">
            <Button
              variant="outline"
              size="icon"
              className="size-12 shrink-0 rounded-full"
              onClick={() => onClick(-1)}
              disabled={amount <= 0}
            >
              <Minus />
              <span className="sr-only">Decrease</span>
            </Button>
            <Label className="text-2xl">{amount}</Label>
            <Button
              variant="outline"
              size="icon"
              className="size-12 shrink-0 rounded-full"
              onClick={() => onClick(+1)}
              disabled={amount >= 20}
            >
              <Plus />
              <span className="sr-only">Increase</span>
            </Button>
          </div>
        </div>
        <DialogFooter>
          <DialogClose asChild>
            <Button
              onClick={() => removeItem()}
              variant="secondary"
              className="h-16 px-10 py-6 text-xl "
              type="button"
            >
              닫기
            </Button>
          </DialogClose>
          <Button
            className="h-16 px-10 py-6 text-xl"
            onClick={() => {
              setLineItem({ ...item, amount })
              removeItem()
              setAmount(0)
            }}
          >
            장바구니 담기
          </Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  )
}
