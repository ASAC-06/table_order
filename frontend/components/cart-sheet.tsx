"use client"

import { useState } from "react"
import { router } from "next/client"
import { useRouter } from "next/navigation"
import { reduce } from "lodash"
import { toast } from "sonner"

import { createOrder } from "@/lib/actions"
import { useLineItemStore, useOrderStore } from "@/lib/store"
import { commaizeNumber } from "@/lib/utils"
import { Button } from "@/components/ui/button"
import { Label } from "@/components/ui/label"
import { ScrollArea } from "@/components/ui/scroll-area"
import {
  Sheet,
  SheetClose,
  SheetContent,
  SheetFooter,
  SheetHeader,
  SheetTitle,
  SheetTrigger,
} from "@/components/ui/sheet"
import { LineItem } from "@/components/line-item"

export function CartSheet() {
  const { lineItems } = useLineItemStore()
  const { setOrder } = useOrderStore()
  const router = useRouter()
  const total_price = reduce(
    lineItems,
    (total, lineItem) => {
      return total + lineItem.price * lineItem.amount
    },
    0
  )
  const total_sum = reduce(
    lineItems,
    (total, lineItem) => {
      return total + lineItem.amount
    },
    0
  )

  const side = "right"
  return (
    <div className="grid grid-cols-2 gap-2">
      <Sheet key={side}>
        <SheetTrigger asChild>
          <Button
            className="h- fixed bottom-10 right-10 h-16 px-10 py-6 text-xl"
            variant="default"
          >
            장바구니
          </Button>
        </SheetTrigger>
        <SheetContent side={side}>
          <SheetHeader>
            <SheetTitle>
              <Label className=" text-2xl text-black">장바구니</Label>
            </SheetTitle>
          </SheetHeader>
          <ScrollArea className="h-[500px]">
            <div className="grid gap-4 py-4">
              {lineItems.map((lineItem) => (
                <LineItem key={lineItem.id} id={lineItem.id} />
              ))}
            </div>
          </ScrollArea>
          <div className="text-right">
            <Label className="text-lg">총 {total_sum}개</Label>

            <div>
              <Label className="text-2xl text-primary">
                {commaizeNumber(total_price)}원
              </Label>
            </div>
          </div>

          <SheetFooter className="fixed bottom-10 right-6">
            <SheetClose asChild>
              <Button variant="secondary" className="h-16 px-10 py-6 text-xl">
                닫기
              </Button>
            </SheetClose>
            <SheetClose asChild>
              <Button
                className="h-16 px-10 py-6 text-xl"
                onClick={async () => {
                  const res = await createOrder(lineItems)
                  if (res) {
                    setOrder(res)
                    router.push("/order")
                  } else {
                    toast.error("주문을 생성할 수 없습니다.")
                  }
                }}
              >
                결제하기
              </Button>
            </SheetClose>
          </SheetFooter>
        </SheetContent>
      </Sheet>
    </div>
  )
}
