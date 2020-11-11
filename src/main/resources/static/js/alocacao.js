let funcionarioIsVisible = false;
let vagaIsVisible = false;

$("#f-card").hide();
$("#v-card").hide();
$("#alocar-icon").hide();

const tecnologiasList = $("#tecnologias tr:has(td)")
  .map(function () {
    const $td = $("td", this);
    return {
      id: $td.eq(0).text(),
      nome: $td.eq(1).text(),
    };
  })
  .get();

function techsToArray(techs) {
  if (!techs) {
    return [];
  }

  techs = techs.toString();

  if (techs.length > 1) {
    return techs.split(",");
  } else {
    return techs.split();
  }
}

function fromIdToNome(techIds) {
  if (techIds.length == 0) {
    return "Nenhuma tecnologia cadastrada";
  }

  return techIds.map((id) => tecnologiasList[id - 1].nome).join(", ");
}

function toggleAlocarIconVisible() {
  return funcionarioIsVisible && vagaIsVisible
    ? $("#alocar-icon").show("slow")
    : $("#alocar-icon").hide("slow");
}

function getOptionData(obj, attr) {
  return $(obj).find(":selected").data(attr);
}

function getOptionText(obj) {
  return $(obj).find(":selected").text();
}

$("#funcionario").change(function () {
  if (this.value.length == 0) {
    $("#f-card").toggle("slow");
    funcionarioIsVisible = false;
    toggleAlocarIconVisible();
    return;
  }

  const nome = getOptionText(this);
  const unidade = getOptionData(this, "unidade");
  const cargo = getOptionData(this, "cargo");
  const techsRaw = getOptionData(this, "tecnologias");
  const techIds = techsToArray(techsRaw);
  const tecnologias = fromIdToNome(techIds);

  $("#f-nome").text(nome);
  $("#f-unidade").text(unidade);
  $("#f-cargo").text(cargo);
  $("#f-tecnologias").text(tecnologias);

  $("#f-card").toggle("slow");
  funcionarioIsVisible = true;
  toggleAlocarIconVisible();
});

$("#vaga").change(function () {
  toggleAlocarIconVisible();

  if (this.value.length == 0) {
    $("#v-card").toggle("slow");
    vagaIsVisible = false;
    toggleAlocarIconVisible();
    return;
  }

  const projeto = getOptionData(this, "projeto");
  const codigo = getOptionData(this, "codigo");
  const descricao = getOptionText(this);
  const techsRaw = getOptionData(this, "tecnologias");
  const techIds = techsToArray(techsRaw);
  const tecnologias = fromIdToNome(techIds);

  $("#v-projeto").text(projeto);
  $("#v-codigo").text(codigo);
  $("#v-descricao").text(descricao);
  $("#v-tecnologias").text(tecnologias);

  $("#v-card").toggle("slow");
  vagaIsVisible = true;
  toggleAlocarIconVisible();
});
