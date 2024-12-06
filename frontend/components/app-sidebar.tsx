import dynamic from "next/dynamic"
import Link from "next/link"

import { API_URL, getCategories } from "@/lib/api"
import { ItemType } from "@/lib/types"
import { Label } from "@/components/ui/label"
import {
  Sidebar,
  SidebarContent,
  SidebarGroup,
  SidebarGroupContent,
  SidebarGroupLabel,
  SidebarHeader,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
} from "@/components/ui/sidebar"
import CategoryList from "@/components/category/category-list"

export async function AppSidebar() {
  const categories = await getCategories()

  return (
    <Sidebar collapsible="none" className="sticky top-0 h-svh border-r lg:flex">
      <SidebarHeader>
        <Label className="m-6 text-center text-2xl text-black">
          <Link href="/">테이블 오더</Link>
        </Label>
      </SidebarHeader>
      <SidebarContent>
        <SidebarGroup>
          <SidebarGroupContent>
            <SidebarMenu>
              <CategoryList categories={categories}></CategoryList>
            </SidebarMenu>
          </SidebarGroupContent>
        </SidebarGroup>
      </SidebarContent>
    </Sidebar>
  )
}
