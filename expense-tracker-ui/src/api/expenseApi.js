import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8085/api"
});

export const fetchExpenses = (params) =>
  API.get("/expenses/filter", { params });
