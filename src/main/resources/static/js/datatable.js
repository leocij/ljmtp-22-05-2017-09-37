$(document).ready( function () {
	 var table = $('#cursosTabela').DataTable({
			"sAjaxSource": "/cursos",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "identifier"},
		      { "mData": "nome" }
			]
	 })
});

$(document).ready( function () {
	 var table = $('#alunosTabela').DataTable({
			"sAjaxSource": "/alunos",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "identifier"},
		      { "mData": "matricula" },
			    { "mData": "nome"},
			    { "mData": "curso"}
			]
	 })
});