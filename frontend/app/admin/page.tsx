"use client"

import { API_URL } from "@/lib/api"
import { ItemForm } from "@/components/item/form"

export default function admin() {
  const formdata = new FormData()

  function sendButtonListener() {
    formdata.append("name", document.getElementById("name_text").toString())
    formdata.append(
      "category",
      document.getElementById("category_text").toString()
    )
    formdata.append("price", document.getElementById("price").toString())
    formdata.append(
      "description",
      document.getElementById("description").toString()
    )
    formdata.append("images", document.getElementById("file").files[0])

    console.log(formdata.get("images"))
  }
  return (
    <>
      <h1>신규 등록</h1>
      <div>
        <p>Admin</p>
        이름 : <input type="text" id="name_text"></input>
        <br />
        카테고리 : <input type="text" id="category_text"></input>
        <br />
        가격 : <input type="type" id="price"></input>
        <br />
        설명 : <input type="type" id="description"></input>
        <br />
        <input type="file" id="files"></input>
        <br />
        <button onClick={sendButtonListener}>버-튼</button>
      </div>
    </>
  )
}
