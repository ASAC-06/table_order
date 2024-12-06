import type { Metadata } from "next"

import "./globals.css"

import { Do_Hyeon } from "next/font/google"

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
      <body className={`${doHyeon.className} antialiased`}>{children} </body>
    </html>
  )
}
