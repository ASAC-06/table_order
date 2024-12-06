import { create } from "zustand"
import { persist } from "zustand/middleware"

import { categoryType, ItemType, LineItemType, OrderType } from "@/lib/types"

interface itemDialogState {
  item: ItemType | undefined
  setItem: (item: ItemType) => void
  removeItem: () => void
}

interface lineItemState {
  lineItems: LineItemType[]
  setLineItem: (item: LineItemType) => void
  resetLineItems: () => void
  findLineItem: (id: number) => LineItemType
}

interface categoriesState {
  categories: categoryType[]
  setCategories: (categories: categoryType[]) => void
}

export const useItemDialogStore = create<itemDialogState>((set) => ({
  item: undefined,
  setItem: (item) => set(() => ({ item: item })),
  removeItem: () => set({ item: undefined }),
}))

export const useLineItemStore = create<lineItemState>()(
  persist(
    (set) => ({
      lineItems: [],
      setLineItem: (newLineItem) =>
        set((state) => {
          console.log("newLineItem", newLineItem)
          console.log("state", state)

          const lineItem = state.lineItems.find(
            (lineItem) => lineItem.id === newLineItem.id
          )

          if (!lineItem && newLineItem.amount <= 0) {
            return { lineItems: state.lineItems }
          }

          if (!lineItem) {
            return { lineItems: [...state.lineItems, { ...newLineItem }] }
          }

          if (lineItem && newLineItem.amount > 0) {
            lineItem.amount = newLineItem.amount
            return { lineItems: [...state.lineItems] }
          }

          return {
            lineItems: state.lineItems.filter(
              (lineItem) => lineItem.id !== newLineItem.id
            ),
          }
        }),
      resetLineItems: () => set({ lineItems: [] }),
      findLineItem: (id: number): LineItemType | undefined => {
        const { lineItems } = useLineItemStore.getState()
        return lineItems.find((lineItem) => lineItem.id === id)
      },
    }),
    { name: "lineItemStore" }
  )
)

export const useCategoriesStore = create<categoriesState>((set) => ({
  categories: [],
  setCategories: (categories) => {
    set(() => ({
      categories: [...categories],
    }))
  },
}))

interface orderState {
  order: OrderType | undefined
  setOrder: (order: any) => void
  removeOrder: () => void
}

export const useOrderStore = create<orderState>((set) => ({
  order: undefined,
  setOrder: (order) => set(() => ({ order })),
  removeOrder: () => set({ order: undefined }),
}))
