package infviewer.workspace.view;

public abstract class RangeElement implements DialogElementInterface 
{
	public enum StartEndPoints 
	{ 
		MIN, MAX, START, END;
		
		@Override
		public String toString()
		{
			return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
		}
	};
	
	protected StartEndPoints endPoint;
	
	public RangeElement(StartEndPoints endPoint)
	{
		this.endPoint = endPoint;
	}
	
	public StartEndPoints getEndPoint()
	{
		return this.endPoint;
	}
}