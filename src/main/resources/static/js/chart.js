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

  if (funcionarios.length < 2) {
    return;
  }

  const responseVagas = await fetch(`${baseUrl}/vagas/por-data`);
  const vagas = await responseVagas.json();

  console.log(vagas);
  console.log(normalizarDatas(vagas));

  const data = new google.visualization.DataTable();
  const data2 = new google.visualization.DataTable();

  data.addColumn("date", "Data");
  data.addColumn("number", "Quantidade Funcionários");
  data.addRows(normalizarDatas(funcionarios));

  data2.addColumn("date", "Data");
  data2.addColumn("number", "Quantidade Vagas");
  data2.addRows(normalizarDatas(vagas));

  var dateRange = data2.getColumnRange(0);
  var mindate = dateRange.min;
  var maxdate = dateRange.max;

  const options = {
    title: "Próximos Vencimentos de WA",
    legend: { position: "bottom" },
    vAxis: {
      format: "#",
      minValue: 0,
    },
    hAxis: {
      format: "dd/MM/yyyy",
      ticks: data.getDistinctValues(0),
      gridlines: {
        count: -1,
      },
    },
  };

  const options2 = {
    title: "Vagas Lançadas por Data",
    legend: { position: "bottom" },
    vAxis: {
      format: "#",
      minValue: 0,
    },
    hAxis: {
      format: "dd/MM/yyyy",
      // viewWindow: {
      //   min: mindate,
      //   max: maxdate,
      // },
      // ticks: data.getDistinctValues(0),
      // gridlines: {
      //   count: -1,
      // },
    },
  };

  // Instantiate and draw the chart.
  const chart = new google.visualization.LineChart(
    document.getElementById("funcionarios-termino-wa")
  );

  const chart2 = new google.visualization.LineChart(
    document.getElementById("vagas")
  );

  chart.draw(data, options);
  chart2.draw(data2, options2);
}
