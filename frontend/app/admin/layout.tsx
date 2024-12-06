import React from "react"

import { AdminHeader } from "@/components/admin/header"

export default function AdminLayout({
  children, // will be a page or nested layout
}: {
  children: React.ReactNode
}) {
  return (
    <>
      <AdminHeader></AdminHeader>
      <main className="m-12 pt-12">{children}</main>
    </>
  )
}
