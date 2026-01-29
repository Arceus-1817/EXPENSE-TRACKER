export default function ExpenseList({ expenses }) {
  return (
    <table>
      <thead>
        <tr>
          <th>Title</th>
          <th>Amount</th>
          <th>Date</th>
        </tr>
      </thead>
      <tbody>
        {expenses.map(e => (
          <tr key={e.id}>
            <td>{e.title}</td>
            <td>{e.amount}</td>
            <td>{e.date}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
