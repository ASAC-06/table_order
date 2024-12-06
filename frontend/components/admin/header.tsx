import React from "react"
import Link from "next/link"

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

export function AdminHeader() {
  return (
    <div className="md:flex md:items-center md:justify-between m-12">
      <div className="min-w-0 flex-1">
        <h2 className="text-2xl/7 font-bold text-gray-900 sm:truncate sm:text-3xl sm:tracking-tight">
          Admin Dashboard
        </h2>
      </div>
      <div className="mt-4 flex md:ml-4 md:mt-0">
        {menus.map((menu) => (
          <Link
            key={menu.title}
            href={menu.url + "/new"}
            className="ml-8 font-medium text-gray-600 hover:text-gray-900"
          >
            {menu.title} new
          </Link>
        ))}
      </div>
    </div>
  )
}
