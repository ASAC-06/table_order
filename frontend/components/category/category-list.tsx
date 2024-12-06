"use client"

import { useHash } from "react-use"

import { SidebarMenuButton, SidebarMenuItem } from "@/components/ui/sidebar"

export default function CategoryList({ categories }) {
  let current = ""
  if (typeof window !== "undefined") {
    const [hash, _] = useHash()
    current = decodeURI(hash)
  }

  return (
    <>
      {categories.map(({ title, url }) => (
        <SidebarMenuItem className="" key={title}>
          <SidebarMenuButton
            className="h-16 p-6"
            asChild
            isActive={`#${title}` === current}
          >
            <a href={url}>
              <span>{title}</span>
            </a>
          </SidebarMenuButton>
        </SidebarMenuItem>
      ))}
    </>
  )
}
