import { useEffect, useState } from "react";

function ExpenseFilter({ onFilter }) {
  const [minAmount, setMinAmount] = useState("");
  const [maxAmount, setMaxAmount] = useState("");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [categoryId, setCategoryId] = useState("");
  const [categories, setCategories] = useState([]);

  // 🔥 Load categories once
  useEffect(() => {
    fetch("http://localhost:8085/api/categories")
      .then(res => res.json())
      .then(data => setCategories(data));
  }, []);

  const applyFilters = () => {
    onFilter({
      minAmount,
      maxAmount,
      startDate,
      endDate,
      categoryId
    });
  };

  return (
    <div>
      <h3>Expense Filter</h3>

      <input
        placeholder="Min Amount"
        value={minAmount}
        onChange={(e) => setMinAmount(e.target.value)}
      />

      <input
        placeholder="Max Amount"
        value={maxAmount}
        onChange={(e) => setMaxAmount(e.target.value)}
      />

      <input
        type="date"
        value={startDate}
        onChange={(e) => setStartDate(e.target.value)}
      />

      <input
        type="date"
        value={endDate}
        onChange={(e) => setEndDate(e.target.value)}
      />

      <select
        value={categoryId}
        onChange={(e) => setCategoryId(e.target.value)}
      >
        <option value="">All Categories</option>

        {categories.map(cat => (
          <option key={cat.id} value={cat.id}>
            {cat.name}
          </option>
        ))}
      </select>

      <br /><br />
      <button onClick={applyFilters}>Apply Filters</button>
    </div>
  );
}

export default ExpenseFilter;
