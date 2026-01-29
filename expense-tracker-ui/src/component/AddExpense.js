import { useEffect, useState } from "react";

function AddExpense({ onExpenseAdded }) {
  const [title, setTitle] = useState("");
  const [amount, setAmount] = useState("");
  const [date, setDate] = useState("");
  const [categoryId, setCategoryId] = useState("");
  const [categories, setCategories] = useState([]);

  // 🔥 load categories when page opens
  useEffect(() => {
    fetch("http://localhost:8085/api/categories")
      .then(res => res.json())
      .then(data => setCategories(data));
  }, []);

  const handleSubmit = async () => {
    await fetch("http://localhost:8085/api/expenses", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        title,
        amount,
        date,
        user: { id: 1 },
        category: { id: categoryId }
      })
    });

    setTitle("");
    setAmount("");
    setDate("");
    setCategoryId("");

    onExpenseAdded();
  };

  return (
    <div>
      <h3>Add Expense</h3>

      <input
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />

      <input
        placeholder="Amount"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
      />

      <input
        type="date"
        value={date}
        onChange={(e) => setDate(e.target.value)}
      />

      <select
        value={categoryId}
        onChange={(e) => setCategoryId(e.target.value)}
      >
        <option value="">Select Category</option>

        {categories.map(cat => (
          <option key={cat.id} value={cat.id}>
            {cat.name}
          </option>
        ))}
      </select>

      <br /><br />
      <button onClick={handleSubmit}>Add Expense</button>
    </div>
  );
}

export default AddExpense;
