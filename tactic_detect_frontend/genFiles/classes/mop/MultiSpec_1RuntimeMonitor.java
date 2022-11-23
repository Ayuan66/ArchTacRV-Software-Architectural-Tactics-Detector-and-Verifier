
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;
import java.lang.ref.*;
import com.runtimeverification.rvmonitor.java.rt.*;
import com.runtimeverification.rvmonitor.java.rt.ref.*;
import com.runtimeverification.rvmonitor.java.rt.table.*;
import com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractIndexingTree;
import com.runtimeverification.rvmonitor.java.rt.tablebase.SetEventDelegator;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TableAdopter.Tuple2;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TableAdopter.Tuple3;
import com.runtimeverification.rvmonitor.java.rt.tablebase.IDisableHolder;
import com.runtimeverification.rvmonitor.java.rt.tablebase.IMonitor;
import com.runtimeverification.rvmonitor.java.rt.tablebase.DisableHolder;
import com.runtimeverification.rvmonitor.java.rt.tablebase.TerminatedMonitorCleaner;
import java.util.concurrent.atomic.AtomicInteger;

final class EchoXorExceptionMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<EchoXorExceptionMonitor> {

	EchoXorExceptionMonitor_Set(){
		this.size = 0;
		this.elements = new EchoXorExceptionMonitor[4];
	}
	final void event_ping() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			EchoXorExceptionMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final EchoXorExceptionMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_ping();
				if(monitorfinalMonitor.EchoXorExceptionMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_echo() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			EchoXorExceptionMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final EchoXorExceptionMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_echo();
				if(monitorfinalMonitor.EchoXorExceptionMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_exception() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			EchoXorExceptionMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final EchoXorExceptionMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_exception();
				if(monitorfinalMonitor.EchoXorExceptionMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}
final class ExceptionTimeMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<ExceptionTimeMonitor> {

	ExceptionTimeMonitor_Set(){
		this.size = 0;
		this.elements = new ExceptionTimeMonitor[4];
	}
	final void event_ping() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			ExceptionTimeMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ExceptionTimeMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_ping();
				if(monitorfinalMonitor.ExceptionTimeMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_echo() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			ExceptionTimeMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ExceptionTimeMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_echo();
				if(monitorfinalMonitor.ExceptionTimeMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_exception() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			ExceptionTimeMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final ExceptionTimeMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_exception();
				if(monitorfinalMonitor.ExceptionTimeMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}
final class PingEchoMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<PingEchoMonitor> {

	PingEchoMonitor_Set(){
		this.size = 0;
		this.elements = new PingEchoMonitor[4];
	}
	final void event_ping() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			PingEchoMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final PingEchoMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_ping();
				if(monitorfinalMonitor.PingEchoMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_echo() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			PingEchoMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final PingEchoMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_echo();
				if(monitorfinalMonitor.PingEchoMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_exception() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			PingEchoMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final PingEchoMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_exception();
				if(monitorfinalMonitor.PingEchoMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}
final class PingEchoExceptionMonitor_Set extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractMonitorSet<PingEchoExceptionMonitor> {

	PingEchoExceptionMonitor_Set(){
		this.size = 0;
		this.elements = new PingEchoExceptionMonitor[4];
	}
	final void event_exception() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			PingEchoExceptionMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final PingEchoExceptionMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_exception();
				if(monitorfinalMonitor.PingEchoExceptionMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
	final void event_handleexception() {
		int numAlive = 0 ;
		for(int i = 0; i < this.size; i++){
			PingEchoExceptionMonitor monitor = this.elements[i];
			if(!monitor.isTerminated()){
				elements[numAlive] = monitor;
				numAlive++;

				final PingEchoExceptionMonitor monitorfinalMonitor = monitor;
				monitor.Prop_1_event_handleexception();
				if(monitorfinalMonitor.PingEchoExceptionMonitor_Prop_1_Category_violation) {
					monitorfinalMonitor.Prop_1_handler_violation();
				}
			}
		}
		for(int i = numAlive; i < this.size; i++){
			this.elements[i] = null;
		}
		size = numAlive;
	}
}

class EchoXorExceptionMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			EchoXorExceptionMonitor ret = (EchoXorExceptionMonitor) super.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	static final int Prop_1_transition_ping[] = {1, 1, 3, 3};;
	static final int Prop_1_transition_echo[] = {2, 1, 3, 3};;
	static final int Prop_1_transition_exception[] = {2, 1, 3, 3};;

	volatile boolean EchoXorExceptionMonitor_Prop_1_Category_violation = false;

	private final AtomicInteger pairValue;

	EchoXorExceptionMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0) ) ;

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get() ) ;
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get() ) ;
	}
	private final int getState(int pairValue) {
		return (pairValue & 3) ;
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 2) ;
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1) << 2) | state) ;
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get() ;
			int oldstate = this.getState(oldpairvalue) ;
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate) ;
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue) ) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_ping() {
		{
			System.out.println("---Ping---");
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_ping) ;
		this.EchoXorExceptionMonitor_Prop_1_Category_violation = nextstate == 2;

		return true;
	}

	final boolean Prop_1_event_echo() {
		{
			System.out.println("---Echo---");
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_echo) ;
		this.EchoXorExceptionMonitor_Prop_1_Category_violation = nextstate == 2;

		return true;
	}

	final boolean Prop_1_event_exception() {
		{
		}

		int nextstate = this.handleEvent(2, Prop_1_transition_exception) ;
		this.EchoXorExceptionMonitor_Prop_1_Category_violation = nextstate == 2;

		return true;
	}

	final void Prop_1_handler_violation (){
		{
			System.out.println("ltl violated!");
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0) ) ;

		EchoXorExceptionMonitor_Prop_1_Category_violation = false;
	}

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//ping
			return;
			case 1:
			//echo
			return;
			case 2:
			//exception
			return;
		}
		return;
	}

	public static int getNumberOfEvents() {
		return 3;
	}

	public static int getNumberOfStates() {
		return 4;
	}

}
class ExceptionTimeMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			ExceptionTimeMonitor ret = (ExceptionTimeMonitor) super.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	static final int Prop_1_transition_ping[] = {1, 1, 3, 3};;
	static final int Prop_1_transition_echo[] = {0, 0, 3, 3};;
	static final int Prop_1_transition_exception[] = {2, 1, 3, 3};;

	volatile boolean ExceptionTimeMonitor_Prop_1_Category_violation = false;

	private final AtomicInteger pairValue;

	ExceptionTimeMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0) ) ;

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get() ) ;
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get() ) ;
	}
	private final int getState(int pairValue) {
		return (pairValue & 3) ;
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 2) ;
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1) << 2) | state) ;
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get() ;
			int oldstate = this.getState(oldpairvalue) ;
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate) ;
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue) ) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_ping() {
		{
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_ping) ;
		this.ExceptionTimeMonitor_Prop_1_Category_violation = nextstate == 2;

		return true;
	}

	final boolean Prop_1_event_echo() {
		{
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_echo) ;
		this.ExceptionTimeMonitor_Prop_1_Category_violation = nextstate == 2;

		return true;
	}

	final boolean Prop_1_event_exception() {
		{
		}

		int nextstate = this.handleEvent(2, Prop_1_transition_exception) ;
		this.ExceptionTimeMonitor_Prop_1_Category_violation = nextstate == 2;

		return true;
	}

	final void Prop_1_handler_violation (){
		{
			System.out.println("ltl violated!");
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0) ) ;

		ExceptionTimeMonitor_Prop_1_Category_violation = false;
	}

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//ping
			return;
			case 1:
			//echo
			return;
			case 2:
			//exception
			return;
		}
		return;
	}

	public static int getNumberOfEvents() {
		return 3;
	}

	public static int getNumberOfStates() {
		return 4;
	}

}
class PingEchoMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			PingEchoMonitor ret = (PingEchoMonitor) super.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	static final int Prop_1_transition_ping[] = {1, 1, 3, 3};;
	static final int Prop_1_transition_echo[] = {2, 0, 3, 3};;
	static final int Prop_1_transition_exception[] = {0, 0, 3, 3};;

	volatile boolean PingEchoMonitor_Prop_1_Category_violation = false;

	private final AtomicInteger pairValue;

	PingEchoMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0) ) ;

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get() ) ;
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get() ) ;
	}
	private final int getState(int pairValue) {
		return (pairValue & 3) ;
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 2) ;
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1) << 2) | state) ;
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get() ;
			int oldstate = this.getState(oldpairvalue) ;
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate) ;
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue) ) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_ping() {
		{
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_ping) ;
		this.PingEchoMonitor_Prop_1_Category_violation = nextstate == 2;

		return true;
	}

	final boolean Prop_1_event_echo() {
		{
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_echo) ;
		this.PingEchoMonitor_Prop_1_Category_violation = nextstate == 2;

		return true;
	}

	final boolean Prop_1_event_exception() {
		{
		}

		int nextstate = this.handleEvent(2, Prop_1_transition_exception) ;
		this.PingEchoMonitor_Prop_1_Category_violation = nextstate == 2;

		return true;
	}

	final void Prop_1_handler_violation (){
		{
			System.out.println("ltl violated!");
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0) ) ;

		PingEchoMonitor_Prop_1_Category_violation = false;
	}

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//ping
			return;
			case 1:
			//echo
			return;
			case 2:
			//exception
			return;
		}
		return;
	}

	public static int getNumberOfEvents() {
		return 3;
	}

	public static int getNumberOfStates() {
		return 4;
	}

}
class PingEchoExceptionMonitor extends com.runtimeverification.rvmonitor.java.rt.tablebase.AbstractAtomicMonitor implements Cloneable, com.runtimeverification.rvmonitor.java.rt.RVMObject {
	protected Object clone() {
		try {
			PingEchoExceptionMonitor ret = (PingEchoExceptionMonitor) super.clone();
			return ret;
		}
		catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	static final int Prop_1_transition_exception[] = {2, 3, 2, 3};;
	static final int Prop_1_transition_handleexception[] = {1, 3, 0, 3};;

	volatile boolean PingEchoExceptionMonitor_Prop_1_Category_violation = false;

	private final AtomicInteger pairValue;

	PingEchoExceptionMonitor() {
		this.pairValue = new AtomicInteger(this.calculatePairValue(-1, 0) ) ;

	}

	@Override public final int getState() {
		return this.getState(this.pairValue.get() ) ;
	}
	@Override public final int getLastEvent() {
		return this.getLastEvent(this.pairValue.get() ) ;
	}
	private final int getState(int pairValue) {
		return (pairValue & 3) ;
	}
	private final int getLastEvent(int pairValue) {
		return (pairValue >> 2) ;
	}
	private final int calculatePairValue(int lastEvent, int state) {
		return (((lastEvent + 1) << 2) | state) ;
	}

	private final int handleEvent(int eventId, int[] table) {
		int nextstate;
		while (true) {
			int oldpairvalue = this.pairValue.get() ;
			int oldstate = this.getState(oldpairvalue) ;
			nextstate = table [ oldstate ];
			int nextpairvalue = this.calculatePairValue(eventId, nextstate) ;
			if (this.pairValue.compareAndSet(oldpairvalue, nextpairvalue) ) {
				break;
			}
		}
		return nextstate;
	}

	final boolean Prop_1_event_exception() {
		{
		}

		int nextstate = this.handleEvent(0, Prop_1_transition_exception) ;
		this.PingEchoExceptionMonitor_Prop_1_Category_violation = nextstate == 1;

		return true;
	}

	final boolean Prop_1_event_handleexception() {
		{
			System.out.println("---Exception Handled---");
		}

		int nextstate = this.handleEvent(1, Prop_1_transition_handleexception) ;
		this.PingEchoExceptionMonitor_Prop_1_Category_violation = nextstate == 1;

		return true;
	}

	final void Prop_1_handler_violation (){
		{
			System.out.println("ltl violated!");
		}

	}

	final void reset() {
		this.pairValue.set(this.calculatePairValue(-1, 0) ) ;

		PingEchoExceptionMonitor_Prop_1_Category_violation = false;
	}

	@Override
	protected final void terminateInternal(int idnum) {
		int lastEvent = this.getLastEvent();

		switch(idnum){
		}
		switch(lastEvent) {
			case -1:
			return;
			case 0:
			//exception
			return;
			case 1:
			//handleexception
			return;
		}
		return;
	}

	public static int getNumberOfEvents() {
		return 2;
	}

	public static int getNumberOfStates() {
		return 4;
	}

}

public final class MultiSpec_1RuntimeMonitor implements com.runtimeverification.rvmonitor.java.rt.RVMObject {
	private static com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager MultiSpec_1MapManager;
	static {
		MultiSpec_1MapManager = new com.runtimeverification.rvmonitor.java.rt.map.RVMMapManager();
		MultiSpec_1MapManager.start();
	}

	// Declarations for the Lock
	static final ReentrantLock MultiSpec_1_RVMLock = new ReentrantLock();
	static final Condition MultiSpec_1_RVMLock_cond = MultiSpec_1_RVMLock.newCondition();

	private static boolean EchoXorException_activated = false;
	private static boolean ExceptionTime_activated = false;
	private static boolean PingEcho_activated = false;
	private static boolean PingEchoException_activated = false;

	// Declarations for Indexing Trees
	private static final EchoXorExceptionMonitor EchoXorException__Map = new EchoXorExceptionMonitor() ;

	private static final ExceptionTimeMonitor ExceptionTime__Map = new ExceptionTimeMonitor() ;

	private static final PingEchoMonitor PingEcho__Map = new PingEchoMonitor() ;

	private static final PingEchoExceptionMonitor PingEchoException__Map = new PingEchoExceptionMonitor() ;

	public static int cleanUp() {
		int collected = 0;
		// indexing trees
		return collected;
	}

	// Removing terminated monitors from partitioned sets
	static {
		TerminatedMonitorCleaner.start() ;
	}
	// Setting the behavior of the runtime library according to the compile-time option
	static {
		RuntimeOption.enableFineGrainedLock(false) ;
	}

	public static final void PingEcho_pingEvent() {
		PingEcho_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		PingEchoMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = PingEcho__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			PingEchoMonitor created = new PingEchoMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final PingEchoMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_ping();
		if(matchedEntryfinalMonitor.PingEchoMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void PingEcho_echoEvent() {
		PingEcho_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		PingEchoMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = PingEcho__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			PingEchoMonitor created = new PingEchoMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final PingEchoMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_echo();
		if(matchedEntryfinalMonitor.PingEchoMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void PingEcho_exceptionEvent() {
		PingEcho_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		PingEchoMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = PingEcho__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			PingEchoMonitor created = new PingEchoMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final PingEchoMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_exception();
		if(matchedEntryfinalMonitor.PingEchoMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void PingEchoException_exceptionEvent() {
		PingEchoException_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		PingEchoExceptionMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = PingEchoException__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			PingEchoExceptionMonitor created = new PingEchoExceptionMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final PingEchoExceptionMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_exception();
		if(matchedEntryfinalMonitor.PingEchoExceptionMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void PingEchoException_handleexceptionEvent() {
		PingEchoException_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		PingEchoExceptionMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = PingEchoException__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			PingEchoExceptionMonitor created = new PingEchoExceptionMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final PingEchoExceptionMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_handleexception();
		if(matchedEntryfinalMonitor.PingEchoExceptionMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void EchoXorException_pingEvent() {
		EchoXorException_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		EchoXorExceptionMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = EchoXorException__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			EchoXorExceptionMonitor created = new EchoXorExceptionMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final EchoXorExceptionMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_ping();
		if(matchedEntryfinalMonitor.EchoXorExceptionMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void EchoXorException_echoEvent() {
		EchoXorException_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		EchoXorExceptionMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = EchoXorException__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			EchoXorExceptionMonitor created = new EchoXorExceptionMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final EchoXorExceptionMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_echo();
		if(matchedEntryfinalMonitor.EchoXorExceptionMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void EchoXorException_exceptionEvent() {
		EchoXorException_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		EchoXorExceptionMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = EchoXorException__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			EchoXorExceptionMonitor created = new EchoXorExceptionMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final EchoXorExceptionMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_exception();
		if(matchedEntryfinalMonitor.EchoXorExceptionMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ExceptionTime_pingEvent() {
		ExceptionTime_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		ExceptionTimeMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = ExceptionTime__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			ExceptionTimeMonitor created = new ExceptionTimeMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final ExceptionTimeMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_ping();
		if(matchedEntryfinalMonitor.ExceptionTimeMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ExceptionTime_echoEvent() {
		ExceptionTime_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		ExceptionTimeMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = ExceptionTime__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			ExceptionTimeMonitor created = new ExceptionTimeMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final ExceptionTimeMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_echo();
		if(matchedEntryfinalMonitor.ExceptionTimeMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

	public static final void ExceptionTime_exceptionEvent() {
		ExceptionTime_activated = true;
		while (!MultiSpec_1_RVMLock.tryLock()) {
			Thread.yield();
		}

		ExceptionTimeMonitor matchedEntry = null;
		{
			// FindOrCreateEntry
			matchedEntry = ExceptionTime__Map;
		}
		// D(X) main:1
		if ((matchedEntry == null) ) {
			// D(X) main:4
			ExceptionTimeMonitor created = new ExceptionTimeMonitor() ;
			matchedEntry = created;
		}
		// D(X) main:8--9
		final ExceptionTimeMonitor matchedEntryfinalMonitor = matchedEntry;
		matchedEntry.Prop_1_event_exception();
		if(matchedEntryfinalMonitor.ExceptionTimeMonitor_Prop_1_Category_violation) {
			matchedEntryfinalMonitor.Prop_1_handler_violation();
		}

		MultiSpec_1_RVMLock.unlock();
	}

}
