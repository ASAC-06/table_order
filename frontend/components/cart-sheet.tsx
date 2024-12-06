"use client"

import { useLineItemStore } from "@/lib/store"
import { Button } from "@/components/ui/button"
import { Label } from "@/components/ui/label"
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

  const side = "right"
  return (
    <div className="grid grid-cols-2 gap-2">
      <Sheet key={side} defaultOpen={true}>
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
          <div className="grid gap-4 py-4">
            {lineItems.map((lineItem) => (
              <LineItem key={lineItem.id} id={lineItem.id} />
            ))}
          </div>
          <SheetFooter className="fixed bottom-10 right-6">
            <SheetClose asChild>
              <Button variant="secondary" className="h-16 px-10 py-6 text-xl">
                닫기
              </Button>
            </SheetClose>
            <SheetClose asChild>
              <Button className="h-16 px-10 py-6 text-xl">결제하기</Button>
            </SheetClose>
          </SheetFooter>
        </SheetContent>
      </Sheet>
    </div>
  )
}
