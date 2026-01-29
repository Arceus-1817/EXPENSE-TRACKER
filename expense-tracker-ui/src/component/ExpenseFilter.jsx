import { useState } from "react";

export default function ExpenseFilter({ onFilter }) {
  const [filters, setFilters] = useState({
    userId: 1,
    minAmount: "",
    maxAmount: "",
    startDate: "",
    endDate: ""
  });

  const handleChange = (e) => {
    setFilters({ ...filters, [e.target.name]: e.target.value });
  };

  return (
    <>
      <input name="minAmount" placeholder="Min Amount" onChange={handleChange} />
      <input name="maxAmount" placeholder="Max Amount" onChange={handleChange} />
      <input type="date" name="startDate" onChange={handleChange} />
      <input type="date" name="endDate" onChange={handleChange} />
      <button onClick={() => onFilter(filters)}>Apply</button>
    </>
  );
}
