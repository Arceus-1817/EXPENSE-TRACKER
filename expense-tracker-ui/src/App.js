import { useState, useEffect } from "react";
import AddExpense from "./component/AddExpense";
import ExpenseFilter from "./component/ExpenseFilter";
import ExpenseList from "./component/ExpenseList";

function App() {
  const [expenses, setExpenses] = useState([]);

  useEffect(() => {
    fetchExpenses(); // load expenses on page open
  }, []);

  // 🔹 SINGLE SOURCE OF TRUTH FOR FETCHING
  const fetchExpenses = async (filters = {}) => {
    const params = new URLSearchParams({
      userId: 1, // temporary hardcoded user
    });

    if (filters.minAmount) params.append("minAmount", filters.minAmount);
    if (filters.maxAmount) params.append("maxAmount", filters.maxAmount);
    if (filters.startDate) params.append("startDate", filters.startDate);
    if (filters.endDate) params.append("endDate", filters.endDate);
    if (filters.categoryId) params.append("categoryId", filters.categoryId);

    try {
      const res = await fetch(
        `http://localhost:8085/api/expenses/filter?${params}`,
      );

      const data = await res.json();

      // backend returns Page<>
      setExpenses(data.content || []);
    } catch (err) {
      console.error("Failed to fetch expenses", err);
    }
  };

  // 🔹 DELETE
  const handleDelete = async (id) => {
    await fetch(`http://localhost:8085/api/expenses/${id}`, {
      method: "DELETE",
    });

    fetchExpenses(); // reload after delete
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Expense Tracker</h2>

      {/* ADD */}
      <AddExpense onExpenseAdded={fetchExpenses} />

      <hr />

      {/* FILTER */}
      <ExpenseFilter onFilter={fetchExpenses} />

      {/* LIST */}
      <ExpenseList expenses={expenses} onDelete={handleDelete} />
    </div>
  );
}

export default App;
