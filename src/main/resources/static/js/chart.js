google.charts.load("current", { packages: ["corechart"], language: "pt-br" });
google.charts.setOnLoadCallback(drawChart);

function normalizarDatas(array) {
  return array.map((item) => {
    return [new Date(item[0]), item[1]];
  });
}

async function drawChart() {
  const baseUrl = "http://localhost:8080/wa";

  // Define the chart to be drawn.

  const response = await fetch(`${baseUrl}/funcionarios/termino-wa`);
  const funcionarios = await response.json();

  const responseVagas = await fetch(`${baseUrl}/vagas/por-data`);
  const vagas = await responseVagas.json();

  const data = new google.visualization.DataTable();

  data.addColumn("date", "Data");
  data.addColumn("number", "Quantidade");
  data.addRows(normalizarDatas(funcionarios));

  const options = {
    title: "Próximos Vencimentos de WA",
    curveType: "function",
    legend: { position: "bottom" },
  };

  // Instantiate and draw the chart.
  const chart = new google.visualization.LineChart(
    document.getElementById("myPieChart")
  );
  chart.draw(data, options);
}
