import { useState } from "react"
import Image from "next/image"
import { Minus, Plus, Trash2 } from "lucide-react"
import { toast } from "sonner"

import { useLineItemStore } from "@/lib/store"
import { LineItemType } from "@/lib/types"
import { commaizeNumber } from "@/lib/utils"
import { Button } from "@/components/ui/button"
import { Card } from "@/components/ui/card"
import { Label } from "@/components/ui/label"

export function LineItem({ id }: { id: number }) {
  const { findLineItem, setLineItem } = useLineItemStore()
  const lineItem = findLineItem(id)
  const [amount, setAmount] = useState(lineItem.amount)

  const onClick = (adjustment: number) => {
    const result = amount + adjustment
    if (result === 0) {
      toast.error("삭제되었습니다.")
    }

    setAmount(result)
    setLineItem({ ...lineItem, amount: result })
  }

  const removeLineItem = () => {
    toast.error("삭제되었습니다.")
    setLineItem({ ...lineItem, amount: 0 })
  }

  return (
    <Card>
      <div className=" flex items-center space-x-4 rounded-md border p-4">
        <Image
          src="https://placehold.co/400x400.png"
          alt="sample image"
          width={100}
          height={100}
          className="rounded-xl object-cover size-24"
          style={{ objectFit: "cover" }}
        ></Image>
        <div className="flex-1 space-y-1">
          <div className="text-sm font-medium leading-none">
            {lineItem.name}
          </div>
          <div className="text-sm font-medium leading-none">
            <div className="text-lg text-primary">
              {commaizeNumber(lineItem.price)}원
            </div>
            <div className="flex items-center justify-end space-x-6">
              <Button
                variant="outline"
                size="icon"
                className="size-6 shrink-0 rounded-full"
                onClick={() => onClick(-1)}
                disabled={amount <= 0}
              >
                <Minus />
                <span className="sr-only">Decrease</span>
              </Button>
              <Label className="text-lg">{amount}개</Label>
              <Button
                variant="outline"
                size="icon"
                className="size-6 shrink-0 rounded-full"
                onClick={() => onClick(+1)}
                disabled={amount >= 20}
              >
                <Plus />
                <span className="sr-only">Increase</span>
              </Button>

              <Button variant="destructive" onClick={() => removeLineItem()}>
                <Trash2></Trash2>
              </Button>
            </div>
          </div>
        </div>
      </div>
    </Card>
  )
}
