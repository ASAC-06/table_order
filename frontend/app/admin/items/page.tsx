import { API_URL, getItems } from "@/lib/api"

export default async function AdminItemList() {
  const items = await getItems()

  return (
    <>
      <h1>Admin Item List</h1>
    </>
  )
}
