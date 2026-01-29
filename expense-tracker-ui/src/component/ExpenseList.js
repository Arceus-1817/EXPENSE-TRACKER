function ExpenseList({ expenses, onDelete }) {
  return (
    <div>
      <h3>Expenses</h3>

      {expenses.length === 0 && <p>No expenses found</p>}

      <table border="1" width="100%">
        <thead>
          <tr>
            <th>Title</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Category</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {expenses.map((exp) => (
            <tr key={exp.id}>
              <td>{exp.title}</td>
              <td>{exp.amount}</td>
              <td>{exp.date}</td>
              <td>{exp.category.name}</td>
              <td>
                <button onClick={() => onDelete(exp.id)}>🗑️</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ExpenseList;
