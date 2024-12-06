export default function AdminLayout({
  children, // will be a page or nested layout
}: {
  children: React.ReactNode
}) {
  return (
    <div className="mx-auto max-w-4xl my-16">
      <div className="mx-auto max-w-3xl">{children}</div>
    </div>
  )
}
