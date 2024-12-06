import Image from "next/image"

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

  return (
    <>
      <SidebarProvider defaultOpen={false}>
        <AppSidebar />
        <main>
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
        </main>
        <Toaster richColors position="bottom-center" />
        <CartSheet></CartSheet>
      </SidebarProvider>
      <SiteFooter></SiteFooter>
    </>
  )
}
