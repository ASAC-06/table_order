import React from "react"
import Link from "next/link"

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

const menus = [
  {
    title: "item",
    url: "/admin/items",
  },
  {
    title: "categories",
    url: "/admin/categories",
  },
]

const crud = [
  {
    title: "list",
    path: "",
  },
  {
    title: "new",
    path: "/new",
  },
  // {
  //   title: "edit",
  //   path: "/edit",
  // },
  // {
  //   title: "delete",
  //   path: "/delete",
  // },
]

export function AdminSidebar() {
  return (
    <Sidebar>
      <SidebarHeader>
        <Label className="m-6 text-center text-2xl text-black">
          <Link href="/">Admin</Link>
        </Label>
      </SidebarHeader>
      <SidebarContent>
        {menus.map((menu) => (
          <SidebarGroup>
            <SidebarGroupLabel>{menu.title}</SidebarGroupLabel>
            <SidebarGroupContent>
              <SidebarMenu>
                {crud.map((action) => (
                  <SidebarMenuItem key={action.title}>
                    <SidebarMenuButton asChild>
                      <Link href={menu.url + action.path}>
                        <span>{action.title}</span>
                      </Link>
                    </SidebarMenuButton>
                  </SidebarMenuItem>
                ))}
              </SidebarMenu>
            </SidebarGroupContent>
          </SidebarGroup>
        ))}
      </SidebarContent>
    </Sidebar>
  )
}
