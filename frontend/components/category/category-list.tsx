"use client"

import { useEffect, useState } from "react"

import { categoryType } from "@/lib/types"
import { SidebarMenuButton, SidebarMenuItem } from "@/components/ui/sidebar"

export default function CategoryList({
  categories,
}: {
  categories: categoryType[]
}) {
  const [current, setCurrent] = useState("")

  useEffect(() => {
    const handleUrlChange = () => {
      setCurrent(decodeURI(window.location.hash))
    }

    handleUrlChange()
    window.addEventListener("hashchange", handleUrlChange)
    return () => window.removeEventListener("hashchange", handleUrlChange)
  }, [current])

  return (
    <>
      {categories.map(({ category_name, category_priority }) => (
        <SidebarMenuItem className="" key={category_priority}>
          <SidebarMenuButton
            className="h-16 p-6"
            asChild
            isActive={`#${category_name}` === current}
          >
            <a href={`#${category_name}`}>
              <span>{category_name}</span>
            </a>
          </SidebarMenuButton>
        </SidebarMenuItem>
      ))}
    </>
  )
}
