// DO NOT EDIT
// Generated by JFlex 1.8.2 http://jflex.de/
// source: analizadorProyectoFina.l

//Nombre: Carranza Escobar Luis Enrique 315286513
//Nombre:
//Nombre:
//Nombre:

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.*;
import java.io.InputStreamReader;
import java.io.IOException;


// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class Yylex {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\2\1\1\2\2\3\22\0\1\1\1\4\1\5"+
    "\2\0\1\6\1\7\1\0\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\0\1\16\12\17\1\20\1\21\1\22"+
    "\1\23\1\24\2\0\32\25\1\26\1\0\1\27\1\0"+
    "\1\25\1\0\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\25\1\36\1\37\1\25\1\40\1\41\1\25\1\42"+
    "\1\43\2\25\1\44\1\45\1\46\1\47\1\50\1\51"+
    "\3\25\1\52\1\53\1\54\7\0\1\2\u0192\0\1\55"+
    "\17\0\2\2\326\0\u0100\2";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\1\1\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\6\21\1\2"+
    "\5\21\1\24\1\1\1\25\1\1\1\26\1\0\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\5\21\1\35\5\21"+
    "\1\36\6\21\1\37\1\0\1\27\11\21\1\40\1\21"+
    "\1\41\6\21\1\42\1\43\3\21\1\44\3\21\1\45"+
    "\2\21\1\46\1\47\1\21\1\50\3\21\1\51\1\52"+
    "\3\21\1\53\2\21\1\54\1\21\1\55\1\56\1\21"+
    "\1\57\1\21\1\60\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\134\0\212\0\270\0\56\0\346\0\56"+
    "\0\56\0\56\0\u0114\0\56\0\56\0\56\0\56\0\56"+
    "\0\u0142\0\u0170\0\u019e\0\u01cc\0\56\0\56\0\u01fa\0\u0228"+
    "\0\u0256\0\u0284\0\u02b2\0\u02e0\0\u030e\0\u033c\0\u036a\0\u0398"+
    "\0\u03c6\0\u03f4\0\56\0\u0422\0\56\0\u0450\0\56\0\270"+
    "\0\270\0\56\0\56\0\56\0\56\0\56\0\u047e\0\u04ac"+
    "\0\u04da\0\u0508\0\u0536\0\u0564\0\u0592\0\u05c0\0\u05ee\0\u061c"+
    "\0\u064a\0\u01cc\0\u0678\0\u06a6\0\u06d4\0\u0702\0\u0730\0\u075e"+
    "\0\56\0\u0450\0\u0450\0\u078c\0\u07ba\0\u07e8\0\u0816\0\u0844"+
    "\0\u0872\0\u08a0\0\u08ce\0\u08fc\0\u01cc\0\u092a\0\u01cc\0\u0958"+
    "\0\u0986\0\u09b4\0\u09e2\0\u0a10\0\u0a3e\0\u01cc\0\u01cc\0\u0a6c"+
    "\0\u0a9a\0\u0ac8\0\u01cc\0\u0af6\0\u0b24\0\u0b52\0\u01cc\0\u0b80"+
    "\0\u0bae\0\u01cc\0\u01cc\0\u0bdc\0\u01cc\0\u0c0a\0\u0c38\0\u0c66"+
    "\0\u01cc\0\u01cc\0\u0c94\0\u0cc2\0\u0cf0\0\u01cc\0\u0d1e\0\u0d4c"+
    "\0\u01cc\0\u0d7a\0\u01cc\0\u01cc\0\u0da8\0\u01cc\0\u0dd6\0\u01cc"+
    "\0\u01cc";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\2\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\24"+
    "\1\27\1\30\1\31\1\32\1\33\1\24\1\34\2\24"+
    "\1\35\1\24\1\36\1\37\1\40\1\24\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\57\0\1\3\40\0\1\3"+
    "\36\0\1\47\32\0\2\50\1\0\2\50\1\51\50\50"+
    "\7\0\1\52\61\0\1\53\65\0\1\54\55\0\1\55"+
    "\55\0\1\56\51\0\1\24\5\0\1\24\2\0\22\24"+
    "\23\0\1\24\5\0\1\24\2\0\14\24\1\57\5\24"+
    "\23\0\1\24\5\0\1\24\2\0\1\60\5\24\1\61"+
    "\4\24\1\62\6\24\23\0\1\24\5\0\1\24\2\0"+
    "\4\24\1\63\6\24\1\64\6\24\23\0\1\24\5\0"+
    "\1\24\2\0\11\24\1\65\10\24\23\0\1\24\5\0"+
    "\1\24\2\0\1\66\10\24\1\67\1\24\1\70\3\24"+
    "\1\71\2\24\23\0\1\24\5\0\1\24\2\0\5\24"+
    "\1\72\4\24\1\73\7\24\5\0\1\3\15\0\1\24"+
    "\5\0\1\24\2\0\12\24\1\35\7\24\23\0\1\24"+
    "\5\0\1\24\2\0\4\24\1\74\15\24\23\0\1\24"+
    "\5\0\1\24\2\0\21\24\1\75\23\0\1\24\5\0"+
    "\1\24\2\0\14\24\1\76\5\24\23\0\1\24\5\0"+
    "\1\24\2\0\13\24\1\77\6\24\23\0\1\24\5\0"+
    "\1\24\2\0\6\24\1\100\13\24\57\0\1\101\2\0"+
    "\2\102\1\0\52\102\1\103\17\0\1\24\5\0\1\24"+
    "\2\0\4\24\1\104\15\24\23\0\1\24\5\0\1\24"+
    "\2\0\15\24\1\105\4\24\23\0\1\24\5\0\1\24"+
    "\2\0\1\106\21\24\23\0\1\24\5\0\1\24\2\0"+
    "\12\24\1\107\7\24\23\0\1\24\5\0\1\24\2\0"+
    "\5\24\1\110\14\24\23\0\1\24\5\0\1\24\2\0"+
    "\17\24\1\111\2\24\23\0\1\24\5\0\1\24\2\0"+
    "\15\24\1\112\4\24\23\0\1\24\5\0\1\24\2\0"+
    "\11\24\1\113\10\24\23\0\1\24\5\0\1\24\2\0"+
    "\13\24\1\114\6\24\23\0\1\24\5\0\1\24\2\0"+
    "\14\24\1\115\5\24\23\0\1\24\5\0\1\24\2\0"+
    "\12\24\1\116\7\24\23\0\1\24\5\0\1\24\2\0"+
    "\16\24\1\117\3\24\23\0\1\24\5\0\1\24\2\0"+
    "\16\24\1\120\3\24\23\0\1\24\5\0\1\24\2\0"+
    "\7\24\1\121\12\24\23\0\1\24\5\0\1\24\2\0"+
    "\17\24\1\122\2\24\23\0\1\24\5\0\1\24\2\0"+
    "\7\24\1\123\12\24\23\0\1\24\5\0\1\24\2\0"+
    "\7\24\1\124\12\24\23\0\1\24\5\0\1\24\2\0"+
    "\1\125\21\24\23\0\1\24\5\0\1\24\2\0\4\24"+
    "\1\126\15\24\23\0\1\24\5\0\1\24\2\0\14\24"+
    "\1\127\5\24\23\0\1\24\5\0\1\24\2\0\16\24"+
    "\1\130\3\24\23\0\1\24\5\0\1\24\2\0\1\131"+
    "\21\24\23\0\1\24\5\0\1\24\2\0\1\24\1\132"+
    "\20\24\23\0\1\24\5\0\1\24\2\0\4\24\1\133"+
    "\15\24\23\0\1\24\5\0\1\24\2\0\15\24\1\134"+
    "\4\24\23\0\1\24\5\0\1\24\2\0\1\135\15\24"+
    "\1\136\3\24\23\0\1\24\5\0\1\24\2\0\2\24"+
    "\1\137\17\24\23\0\1\24\5\0\1\24\2\0\17\24"+
    "\1\140\2\24\23\0\1\24\5\0\1\24\2\0\16\24"+
    "\1\141\3\24\23\0\1\24\5\0\1\24\2\0\4\24"+
    "\1\142\15\24\23\0\1\24\5\0\1\24\2\0\3\24"+
    "\1\143\16\24\23\0\1\24\5\0\1\24\2\0\11\24"+
    "\1\144\10\24\23\0\1\24\5\0\1\24\2\0\10\24"+
    "\1\145\11\24\23\0\1\24\5\0\1\24\2\0\7\24"+
    "\1\146\12\24\23\0\1\24\5\0\1\24\2\0\17\24"+
    "\1\147\2\24\23\0\1\24\5\0\1\24\2\0\11\24"+
    "\1\150\10\24\23\0\1\24\5\0\1\24\2\0\4\24"+
    "\1\151\15\24\23\0\1\24\5\0\1\24\2\0\16\24"+
    "\1\152\3\24\23\0\1\24\5\0\1\24\2\0\1\153"+
    "\21\24\23\0\1\24\5\0\1\24\2\0\14\24\1\154"+
    "\5\24\23\0\1\24\5\0\1\24\2\0\2\24\1\155"+
    "\17\24\23\0\1\24\5\0\1\24\2\0\4\24\1\156"+
    "\15\24\23\0\1\24\5\0\1\24\2\0\12\24\1\157"+
    "\7\24\23\0\1\24\5\0\1\24\2\0\11\24\1\160"+
    "\10\24\23\0\1\24\5\0\1\24\2\0\4\24\1\161"+
    "\15\24\23\0\1\24\5\0\1\24\2\0\12\24\1\162"+
    "\7\24\23\0\1\24\5\0\1\24\2\0\12\24\1\163"+
    "\7\24\23\0\1\24\5\0\1\24\2\0\6\24\1\164"+
    "\13\24\23\0\1\24\5\0\1\24\2\0\17\24\1\165"+
    "\2\24\23\0\1\24\5\0\1\24\2\0\16\24\1\166"+
    "\3\24\23\0\1\24\5\0\1\24\2\0\16\24\1\167"+
    "\3\24\23\0\1\24\5\0\1\24\2\0\4\24\1\170"+
    "\15\24\23\0\1\24\5\0\1\24\2\0\4\24\1\171"+
    "\15\24\4\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3588];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\1\1\3\11\1\1\5\11"+
    "\4\1\2\11\14\1\1\11\1\1\1\11\1\1\1\11"+
    "\1\0\1\1\5\11\22\1\1\11\1\0\67\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[121];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */

	Parser par;

	public Token nextToken(String lex, int num){
		return new Token(num, lex);
	}

	public Token nextToken(String lex, int num, int tipo){
		return new Token(num, lex, tipo);
	}

	public void initPar(Parser par){
		this.par = par;
	}



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.out.println("Error al identificar token");
	return new Token(1047,"EOF");
            }
            // fall through
          case 50: break;
          case 2:
            { /*El analizador ignora*/
            }
            // fall through
          case 51: break;
          case 3:
            { return new Token(1046,"diferenteuni");
            }
            // fall through
          case 52: break;
          case 4:
            { return new Token(1027, "%");
            }
            // fall through
          case 53: break;
          case 5:
            { return new Token(1020, "(");
            }
            // fall through
          case 54: break;
          case 6:
            { return new Token(1021, ")");
            }
            // fall through
          case 55: break;
          case 7:
            { return new Token(1025, "*");
            }
            // fall through
          case 56: break;
          case 8:
            { return new Token(1023, "=");
            }
            // fall through
          case 57: break;
          case 9:
            { return new Token(1039," , ");
            }
            // fall through
          case 58: break;
          case 10:
            { return new Token(1024, "-");
            }
            // fall through
          case 59: break;
          case 11:
            { return new Token(1026, "/");
            }
            // fall through
          case 60: break;
          case 12:
            { return new Token(1038," : ");
            }
            // fall through
          case 61: break;
          case 13:
            { return new Token(1037," ; ");
            }
            // fall through
          case 62: break;
          case 14:
            { return new Token(1033," < ");
            }
            // fall through
          case 63: break;
          case 15:
            { return new Token(1022, "=");
            }
            // fall through
          case 64: break;
          case 16:
            { return new Token(1028," > ");
            }
            // fall through
          case 65: break;
          case 17:
            { return new Token(1014,"id");
            }
            // fall through
          case 66: break;
          case 18:
            { return new Token(1040," [ ");
            }
            // fall through
          case 67: break;
          case 19:
            { return new Token(1041," ] ");
            }
            // fall through
          case 68: break;
          case 20:
            { return new Token(1044,"{");
            }
            // fall through
          case 69: break;
          case 21:
            { return new Token(1045,"}");
            }
            // fall through
          case 70: break;
          case 22:
            { return new Token(1032," !=");
            }
            // fall through
          case 71: break;
          case 23:
            { return new Token(1043,"cadena");
            }
            // fall through
          case 72: break;
          case 24:
            { return new Token(1030,"and");
            }
            // fall through
          case 73: break;
          case 25:
            { return new Token(1028,"incremento");
            }
            // fall through
          case 74: break;
          case 26:
            { return new Token(1035," <= ");
            }
            // fall through
          case 75: break;
          case 27:
            { return new Token(1031," == ");
            }
            // fall through
          case 76: break;
          case 28:
            { return new Token(1036," >= ");
            }
            // fall through
          case 77: break;
          case 29:
            { return new Token(1005,"do");
            }
            // fall through
          case 78: break;
          case 30:
            { return new Token(1006,"if");
            }
            // fall through
          case 79: break;
          case 31:
            { return new Token(1029,"or");
            }
            // fall through
          case 80: break;
          case 32:
            { return new Token(1010,"for");
            }
            // fall through
          case 81: break;
          case 33:
            { return new Token(1015,"int");
            }
            // fall through
          case 82: break;
          case 34:
            { return new Token(1008,"case");
            }
            // fall through
          case 83: break;
          case 35:
            { return new Token(1017,"char");
            }
            // fall through
          case 84: break;
          case 36:
            { return new Token(1002,"else");
            }
            // fall through
          case 85: break;
          case 37:
            { return new Token(1004,"func");
            }
            // fall through
          case 86: break;
          case 38:
            { return new Token(1000,"true");
            }
            // fall through
          case 87: break;
          case 39:
            { return new Token(1019, "void");
            }
            // fall through
          case 88: break;
          case 40:
            { return new Token(1012,"break");
            }
            // fall through
          case 89: break;
          case 41:
            { return new Token(1001,"false");
            }
            // fall through
          case 90: break;
          case 42:
            { return new Token(1016,"float");
            }
            // fall through
          case 91: break;
          case 43:
            { return new Token(1003,"while");
            }
            // fall through
          case 92: break;
          case 44:
            { return new Token(1018,"double");
            }
            // fall through
          case 93: break;
          case 45:
            { return new Token(1011,"return");
            }
            // fall through
          case 94: break;
          case 46:
            { return new Token(1007,"switch");
            }
            // fall through
          case 95: break;
          case 47:
            { return new Token(1009,"default");
            }
            // fall through
          case 96: break;
          case 48:
            { return new Token(1013,"continue");
            }
            // fall through
          case 97: break;
          case 49:
            { return new Token(1042,"numero");
            }
            // fall through
          case 98: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}