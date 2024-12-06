import dynamic from "next/dynamic"

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

const categories = ["메인메뉴", "파스타", "피자", "음료", "주류"].map(
  (item) => ({
    title: item,
    url: `#${item}`,
  })
)
const CategoryList = dynamic(
  () => import("../components/category/category-list"),
  {
    ssr: false,
  }
)

export function AppSidebar() {
  return (
    <Sidebar collapsible="none" className="sticky top-0 h-svh border-r lg:flex">
      <SidebarHeader>
        <Label className="m-6 text-center text-2xl text-black">
          테이블 오더
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
