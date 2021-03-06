/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package if4031;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-9-22")
public class ChannelLastMsg implements org.apache.thrift.TBase<ChannelLastMsg, ChannelLastMsg._Fields>, java.io.Serializable, Cloneable, Comparable<ChannelLastMsg> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ChannelLastMsg");

  private static final org.apache.thrift.protocol.TField LAST_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("lastID", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField CHANNEL_FIELD_DESC = new org.apache.thrift.protocol.TField("channel", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ChannelLastMsgStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ChannelLastMsgTupleSchemeFactory());
  }

  public int lastID; // required
  public String channel; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    LAST_ID((short)1, "lastID"),
    CHANNEL((short)2, "channel");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // LAST_ID
          return LAST_ID;
        case 2: // CHANNEL
          return CHANNEL;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __LASTID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.LAST_ID, new org.apache.thrift.meta_data.FieldMetaData("lastID", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CHANNEL, new org.apache.thrift.meta_data.FieldMetaData("channel", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ChannelLastMsg.class, metaDataMap);
  }

  public ChannelLastMsg() {
  }

  public ChannelLastMsg(
    int lastID,
    String channel)
  {
    this();
    this.lastID = lastID;
    setLastIDIsSet(true);
    this.channel = channel;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ChannelLastMsg(ChannelLastMsg other) {
    __isset_bitfield = other.__isset_bitfield;
    this.lastID = other.lastID;
    if (other.isSetChannel()) {
      this.channel = other.channel;
    }
  }

  public ChannelLastMsg deepCopy() {
    return new ChannelLastMsg(this);
  }

  @Override
  public void clear() {
    setLastIDIsSet(false);
    this.lastID = 0;
    this.channel = null;
  }

  public int getLastID() {
    return this.lastID;
  }

  public ChannelLastMsg setLastID(int lastID) {
    this.lastID = lastID;
    setLastIDIsSet(true);
    return this;
  }

  public void unsetLastID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LASTID_ISSET_ID);
  }

  /** Returns true if field lastID is set (has been assigned a value) and false otherwise */
  public boolean isSetLastID() {
    return EncodingUtils.testBit(__isset_bitfield, __LASTID_ISSET_ID);
  }

  public void setLastIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LASTID_ISSET_ID, value);
  }

  public String getChannel() {
    return this.channel;
  }

  public ChannelLastMsg setChannel(String channel) {
    this.channel = channel;
    return this;
  }

  public void unsetChannel() {
    this.channel = null;
  }

  /** Returns true if field channel is set (has been assigned a value) and false otherwise */
  public boolean isSetChannel() {
    return this.channel != null;
  }

  public void setChannelIsSet(boolean value) {
    if (!value) {
      this.channel = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case LAST_ID:
      if (value == null) {
        unsetLastID();
      } else {
        setLastID((Integer)value);
      }
      break;

    case CHANNEL:
      if (value == null) {
        unsetChannel();
      } else {
        setChannel((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case LAST_ID:
      return Integer.valueOf(getLastID());

    case CHANNEL:
      return getChannel();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case LAST_ID:
      return isSetLastID();
    case CHANNEL:
      return isSetChannel();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ChannelLastMsg)
      return this.equals((ChannelLastMsg)that);
    return false;
  }

  public boolean equals(ChannelLastMsg that) {
    if (that == null)
      return false;

    boolean this_present_lastID = true;
    boolean that_present_lastID = true;
    if (this_present_lastID || that_present_lastID) {
      if (!(this_present_lastID && that_present_lastID))
        return false;
      if (this.lastID != that.lastID)
        return false;
    }

    boolean this_present_channel = true && this.isSetChannel();
    boolean that_present_channel = true && that.isSetChannel();
    if (this_present_channel || that_present_channel) {
      if (!(this_present_channel && that_present_channel))
        return false;
      if (!this.channel.equals(that.channel))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_lastID = true;
    list.add(present_lastID);
    if (present_lastID)
      list.add(lastID);

    boolean present_channel = true && (isSetChannel());
    list.add(present_channel);
    if (present_channel)
      list.add(channel);

    return list.hashCode();
  }

  @Override
  public int compareTo(ChannelLastMsg other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetLastID()).compareTo(other.isSetLastID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastID, other.lastID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetChannel()).compareTo(other.isSetChannel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetChannel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.channel, other.channel);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ChannelLastMsg(");
    boolean first = true;

    sb.append("lastID:");
    sb.append(this.lastID);
    first = false;
    if (!first) sb.append(", ");
    sb.append("channel:");
    if (this.channel == null) {
      sb.append("null");
    } else {
      sb.append(this.channel);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ChannelLastMsgStandardSchemeFactory implements SchemeFactory {
    public ChannelLastMsgStandardScheme getScheme() {
      return new ChannelLastMsgStandardScheme();
    }
  }

  private static class ChannelLastMsgStandardScheme extends StandardScheme<ChannelLastMsg> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ChannelLastMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // LAST_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.lastID = iprot.readI32();
              struct.setLastIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CHANNEL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.channel = iprot.readString();
              struct.setChannelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ChannelLastMsg struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(LAST_ID_FIELD_DESC);
      oprot.writeI32(struct.lastID);
      oprot.writeFieldEnd();
      if (struct.channel != null) {
        oprot.writeFieldBegin(CHANNEL_FIELD_DESC);
        oprot.writeString(struct.channel);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ChannelLastMsgTupleSchemeFactory implements SchemeFactory {
    public ChannelLastMsgTupleScheme getScheme() {
      return new ChannelLastMsgTupleScheme();
    }
  }

  private static class ChannelLastMsgTupleScheme extends TupleScheme<ChannelLastMsg> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ChannelLastMsg struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetLastID()) {
        optionals.set(0);
      }
      if (struct.isSetChannel()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetLastID()) {
        oprot.writeI32(struct.lastID);
      }
      if (struct.isSetChannel()) {
        oprot.writeString(struct.channel);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ChannelLastMsg struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.lastID = iprot.readI32();
        struct.setLastIDIsSet(true);
      }
      if (incoming.get(1)) {
        struct.channel = iprot.readString();
        struct.setChannelIsSet(true);
      }
    }
  }

}

