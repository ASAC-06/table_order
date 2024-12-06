"use client"

import { useEffect, useState } from "react"
import { redirect } from "next/navigation"
import { loadTossPayments } from "@tosspayments/tosspayments-sdk"
import { ArrowLeft } from "lucide-react"

import { useOrderStore } from "@/lib/store"
import { OrderType } from "@/lib/types"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card"

const clientKey = "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm"
const customerKey = "XtcYM3owt-UKbxwRcTwNX"

export default function Payment() {
  const { order } = useOrderStore()

  if (!order) {
    redirect("/")
  }

  const amount = {
    currency: "KRW",
    value: 100, // order.total_price,
  }
  const [ready, setReady] = useState(false)
  const [widgets, setWidgets] = useState(null)

  useEffect(() => {
    async function fetchPaymentWidgets() {
      const tossPayments = await loadTossPayments(clientKey)
      const widgets = tossPayments.widgets({
        customerKey,
      })
      setWidgets(widgets)
    }

    fetchPaymentWidgets()
  }, [clientKey, customerKey])

  useEffect(() => {
    async function renderPaymentWidgets() {
      if (widgets == null) {
        return
      }
      await widgets.setAmount(amount)
      await Promise.all([
        widgets.renderPaymentMethods({
          selector: "#payment-method",
          variantKey: "DEFAULT",
        }),
        widgets.renderAgreement({
          selector: "#agreement",
          variantKey: "AGREEMENT",
        }),
      ])

      setReady(true)
    }

    renderPaymentWidgets()
  }, [widgets])

  useEffect(() => {
    if (widgets == null) {
      return
    }

    widgets.setAmount(amount)
  }, [widgets, amount])

  return (
    <Card>
      <CardHeader>
        <CardTitle>결제</CardTitle>
        <Button
          variant="outline"
          className=" fixed top-6 left-6"
          onClick={() => redirect("/")}
        >
          <ArrowLeft></ArrowLeft>
        </Button>
      </CardHeader>
      <CardContent>
        <div className="">
          <div className="m-auto text-center">
            <div id="payment-method" />
            <div id="agreement" />
            <Button
              className="text-xl p-6"
              disabled={!ready}
              onClick={async () => {
                try {
                  await widgets.requestPayment({
                    orderId: `${order.order_number}_${order.table_number}`,
                    orderName: `${order.table_number}번 테이블 주문`,
                    successUrl: window.location.origin + "/order/success",
                    failUrl: window.location.origin + "/order/fail",
                    customerName: `${order.table_number}번 테이블`,
                  })
                } catch (error) {
                  console.error(error)
                }
              }}
            >
              결제하기
            </Button>
          </div>
        </div>
      </CardContent>
    </Card>
  )
}
