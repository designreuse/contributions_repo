
<div class="modal fade" id="countryPopUp" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Select Country</h4>
			</div>
			<div class="modal-body">
				<div class="alert alert-danger alert-dismissible" role="alert"
					id="errorDiv" style="display: none;">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
				</div>


				<table id="country" class="table table-hover table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Code</th>
							<th>ID</th>
							<th>Country</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-primary"
					onclick="selectCountry();" value="OK">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="countyPopUp" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Select County/State</h4>
			</div>
			<div class="modal-body">
				<div class="alert alert-danger alert-dismissible" role="alert"
					id="errorDiv" style="display: none;">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
				</div>


				<table id="county" class="table table-hover table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Code</th>
							<th>ID</th>
							<th>County/State</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-primary"
					 value="OK" onclick="selectCounty();">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="townPopUp" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Select Town</h4>
			</div>
			<div class="modal-body">
				<div class="alert alert-danger alert-dismissible" role="alert"
					id="errorDiv" style="display: none;">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
				</div>


				<table id="town" class="table table-hover table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Code</th>
							<th>ID</th>
							<th>Town</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-primary"
					 value="OK" onclick="selectTown();">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="currencyPopUp" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Select Currency</h4>
			</div>
			<div class="modal-body">
				<div class="alert alert-danger alert-dismissible" role="alert"
					id="errorDiv" style="display: none;">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
				</div>


				<table id="currencies" class="table table-hover table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Code</th>
							<th>ISO Code</th>
							<th>Currency</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-primary"
					 value="OK" onclick="selectCurrency();">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>