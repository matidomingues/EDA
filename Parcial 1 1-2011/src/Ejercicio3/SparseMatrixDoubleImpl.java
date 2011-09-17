package Ejercicio3;

import java.util.LinkedList;

import Ejercicio3.InternList.Data;

public class SparseMatrixDoubleImpl implements SparseMatrixDouble {
	
	private LinkedList<InternList> data = new LinkedList<InternList>();
	
	
	@Override
	public void set(int row, int col, Double value) {
		for(InternList a: data){
			if(a.getElem().equals(row)){
				a.add(col, value);
				return;
			}
		}
		InternList info = new InternList(row);
		info.add(col, value);
		data.add(info);
	}

	@Override
	public void remove(int row, int col) {
		for(InternList a: data){
			if(a.getElem().equals(row)){
				a.remove(col);
			}
		}
	}

	@Override
	public Double get(int row, int col) {
		for(InternList a: data){
			if(a.getElem().equals(row)){
				return a.getData(col);
			}
		}
		return null;
	}

	
	
	@Override
	public SparseMatrixDouble sum(SparseMatrixDouble otherSparseMatrix) {
		SparseMatrixDoubleImpl m3 = new SparseMatrixDoubleImpl();
		sum(this, m3);
		sum((SparseMatrixDoubleImpl)otherSparseMatrix, m3);
		return (SparseMatrixDouble) m3;
	}
	
	private void sum(SparseMatrixDoubleImpl sp, SparseMatrixDoubleImpl m3){
		Double item;
		for(InternList elems: sp.data){
			for(Data elems2: elems.data){
				item = m3.get(elems.elem, elems2.key);
				if(item == null){
					m3.set(elems.elem, elems2.key, sp.get(elems.elem, elems2.key));
				}else{
					m3.set(elems.elem, elems2.key, item + sp.get(elems.elem, elems2.key));
				}
			}
		}
	}

}
