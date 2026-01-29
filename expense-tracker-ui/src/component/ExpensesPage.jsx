import { useState, useEffect } from "react";
import { fetchExpenses } from "../api/expenseApi";
import ExpenseFilter from "../components/ExpenseFilter";
import ExpenseList from "../components/ExpenseList";

export default function ExpensesPage() {
  const [expenses, setExpenses] = useState([]);

  const loadExpenses = async (filters) => {
    const res = await fetchExpenses(filters);
    setExpenses(res.data.content);
  };

  useEffect(() => {
    loadExpenses({ userId: 1 });
  }, []);

  return (
    <>
      <ExpenseFilter onFilter={loadExpenses} />
      <ExpenseList expenses={expenses} />
    </>
  );
}
