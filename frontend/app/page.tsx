import Image from "next/image"
import { groupBy } from "lodash"

import { API_URL, getItems } from "@/lib/api"
import { ItemType } from "@/lib/types"
import { SidebarProvider } from "@/components/ui/sidebar"
import { Toaster } from "@/components/ui/sonner"
import { AppSidebar } from "@/components/app-sidebar"
import { CartSheet } from "@/components/cart-sheet"
import { SiteFooter } from "@/components/footer"
import { ItemCard } from "@/components/item/card"
import { ItemDialog } from "@/components/item/dialog"
import ItemGrid from "@/components/item/grid"

export default async function Home() {
  const items = await getItems()
  const res = groupBy(items, (item: ItemType) => item.category_name)

  return (
    <>
      <SidebarProvider defaultOpen={false}>
        <AppSidebar />
        <main>
          <div className="p-6">
            <ItemDialog />
            {Object.keys(res).map((category) => (
              <div id={category} key={category}>
                <h2 className="text-2xl font-bold">{category}</h2>
                <ItemGrid>
                  {res[category].map((item) => (
                    <ItemCard key={item.id} {...item}></ItemCard>
                  ))}
                </ItemGrid>
              </div>
            ))}
          </div>
        </main>
        <Toaster richColors position="bottom-center" />
        <CartSheet></CartSheet>
      </SidebarProvider>
      <SiteFooter></SiteFooter>
    </>
  )
}
