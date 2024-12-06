import type { Metadata } from "next"

import "./globals.css"

import { Do_Hyeon } from "next/font/google"

import { getCategories } from "@/lib/api"
import { useCategoriesStore } from "@/lib/store"
import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar"
import { Toaster } from "@/components/ui/sonner"
import { AppSidebar } from "@/components/app-sidebar"
import { CartSheet } from "@/components/cart-sheet"
import { SiteFooter } from "@/components/footer"

export const metadata: Metadata = {
  title: "Table Order",
  description: "ASAC Table Order",
}

const doHyeon = Do_Hyeon({
  weight: "400",
  subsets: ["latin"],
  display: "swap",
})

export default async function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode
}>) {
  return (
    <html lang="ko">
      <body className={`${doHyeon.className} antialiased`}>
        <SidebarProvider defaultOpen={false}>
          <AppSidebar />
          <main>{children}</main>
          <Toaster richColors position="bottom-center" />
          <CartSheet></CartSheet>
        </SidebarProvider>
        <SiteFooter></SiteFooter>
      </body>
    </html>
  )
}
